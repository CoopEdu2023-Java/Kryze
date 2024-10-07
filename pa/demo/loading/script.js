window.addEventListener('load', function () {
  const loader = document.getElementById('loader');
  const content = document.querySelector('.content');

  // 隐藏加载动画并显示页面内容
  loader.style.display = 'none';
  content.style.display = 'block';
  document.body.style.overflow = 'auto'; // 允许滚动页面
});
