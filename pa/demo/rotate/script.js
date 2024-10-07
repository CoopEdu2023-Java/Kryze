// 创建场景、相机和渲染器
const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
const renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true });
renderer.setSize(window.innerWidth, window.innerHeight);
document.body.appendChild(renderer.domElement);

// 创建球体几何体
const sphereGeometry = new THREE.SphereGeometry(5, 32, 32);
const sphereMaterial = new THREE.MeshStandardMaterial({ color: 0x888888, wireframe: true });
const sphere = new THREE.Mesh(sphereGeometry, sphereMaterial);
scene.add(sphere);

// 球体倾斜 - 沿Z轴向左倾斜
sphere.rotation.z = Math.PI / 6; // 30度倾斜

// 添加光源
const ambientLight = new THREE.AmbientLight(0xffffff, 0.6);
scene.add(ambientLight);

const pointLight = new THREE.PointLight(0xffffff, 1);
pointLight.position.set(10, 10, 10);
scene.add(pointLight);

// 创建标签平面
const tagGeometry = new THREE.PlaneGeometry(2.5, 1);
const tagMaterial = new THREE.MeshBasicMaterial({ color: 0xffffff, side: THREE.DoubleSide });
const tag = new THREE.Mesh(tagGeometry, tagMaterial);
scene.add(tag);

// 使用纹理加载器为标签添加文本
const loader = new THREE.TextureLoader();
loader.load('https://via.placeholder.com/250/ffffff/000000?text=数学组', (texture) => {
  tagMaterial.map = texture;
  tagMaterial.needsUpdate = true;
});

// 设置相机位置
camera.position.set(0, 15, 20);
camera.lookAt(0, 0, 0);

// 动画循环
function animate() {
  requestAnimationFrame(animate);

  // 标签沿着倾斜的球体轨迹旋转
  const elapsedTime = Date.now() * 0.001; // 时间，以秒为单位
  const radius = 7; // 标签距离球体中心的距离
  const tiltAngle = Math.PI / 6; // 球体倾斜角度（30度）

  // 计算标签的位置，使其沿着倾斜轨迹旋转
  const x = radius * Math.cos(elapsedTime);
  const y = radius * Math.sin(elapsedTime) * Math.cos(tiltAngle); // Y方向考虑倾斜
  const z = radius * Math.sin(elapsedTime) * Math.sin(tiltAngle); // Z方向也需要考虑倾斜

  tag.position.set(x, y, z);

  // 使标签始终面向相机（保持比例不变，只是远近效果）
  tag.lookAt(camera.position);

  // 渲染场景
  renderer.render(scene, camera);
}

// 处理窗口大小调整
window.addEventListener('resize', () => {
  camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();
  renderer.setSize(window.innerWidth, window.innerHeight);
});

// 启动动画循环
animate();
