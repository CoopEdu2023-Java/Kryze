// 创建场景
const scene = new THREE.Scene();

// 创建相机
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
camera.position.z = 5;

// 创建渲染器
const renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight);
document.body.appendChild(renderer.domElement);

// 创建球体
const geometry = new THREE.SphereGeometry(1, 32, 32);
const material = new THREE.MeshBasicMaterial({ color: 0x0077ff, wireframe: true });
const sphere = new THREE.Mesh(geometry, material);
scene.add(sphere);

// 创建标签的父对象
const labelParent = new THREE.Object3D();
scene.add(labelParent);

// 创建标签
const labelGeometry = new THREE.PlaneGeometry(0.5, 0.2);
const labelMaterial = new THREE.MeshBasicMaterial({ color: 0xffffff, side: THREE.DoubleSide });
const label = new THREE.Mesh(labelGeometry, labelMaterial);
// 将标签位置设置得更靠近球体，且 z 轴上稍微移到后面以便被球体遮住
label.position.set(1.5, 0, -0.5); // z 坐标设为 -0.5，确保标签在球体后方
labelParent.add(label);

// 设置球体和标签的渲染顺序
sphere.renderOrder = 0; // 确保球体在标签之后渲染
label.renderOrder = 1; // 标签先渲染

// 使标签的轨道倾斜-15度
labelParent.rotation.x = THREE.MathUtils.degToRad(-15);

// 旋转速度
let rotationSpeed = 0.01;
let isMouseOverLabel = false;
let isMouseDown = false;
let previousMouseX = 0;

// 创建射线投射器
const raycaster = new THREE.Raycaster();
const mouse = new THREE.Vector2();

// 监听鼠标移动事件
document.addEventListener('mousemove', (event) => {
  // 将鼠标位置转换为标准化设备坐标
  mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
  mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;

  // 更新射线投射器
  raycaster.setFromCamera(mouse, camera);

  // 检测与标签的交互
  const intersects = raycaster.intersectObject(label);
  if (intersects.length > 0) {
    isMouseOverLabel = true;
  } else {
    isMouseOverLabel = false;
  }

  // 检查鼠标是否按下，并根据鼠标移动方向调整旋转方向
  if (isMouseDown) {
    const deltaX = event.clientX - previousMouseX;
    labelParent.rotation.y += deltaX * 0.01; // 根据鼠标X轴的移动调整旋转方向和速度
  }

  previousMouseX = event.clientX; // 更新上一次的鼠标X位置
});

// 监听鼠标按下事件
document.addEventListener('mousedown', (event) => {
  isMouseDown = true;
  previousMouseX = event.clientX; // 记录按下时的鼠标X位置
});

// 监听鼠标抬起事件
document.addEventListener('mouseup', () => {
  isMouseDown = false;
});

// 动画函数
function animate() {
  requestAnimationFrame(animate);

  // 默认旋转
  if (!isMouseDown) {
    labelParent.rotation.y += rotationSpeed; // 默认旋转速度
  }

  // 根据鼠标状态调整标签大小
  if (isMouseOverLabel) {
    label.scale.set(1.5, 1.5, 1.5); // 放大标签
  } else {
    label.scale.set(1, 1, 1); // 恢复标签大小
  }

  // 使标签始终面向相机
  label.lookAt(camera.position);

  renderer.render(scene, camera);
}

animate();
