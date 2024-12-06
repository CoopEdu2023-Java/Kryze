import React, { useEffect, useState } from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/swiper-bundle.css';
import './SwiperComponent.css'; // 引入CSS文件
// import 'swiper/css/pagination';
import { Pagination } from 'swiper/modules';

// 生成随机颜色的函数
const getRandomColor = () => {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
};

const SwiperComponent: React.FC = () => {
  const slidesData = [
    "posblock1",
    "posblock2",
    // "posblock3",
    "Artifact's Name 1",
    "Artifact's Name 2",
    "Artifact's Name 3",
    "Artifact's Name 4",
    "Artifact's Name 5",
    "Artifact's Name 6",
    "Artifact's Name 7",
    "Artifact's Name 8"
  ];
  const [isInitial, setIsInitial] = useState<boolean>(true);
  useEffect
  const handleLeftButtonClick = () => {}
  const handleRightButtonClick = () => {}
  return (
    <div className="swiper-container">
      {/* 左上角按钮 */}
      <button
        className="top-left-button"
        onClick={handleLeftButtonClick}
      >
        <img src="back.svg" alt="Right Button" />
      </button>

      {/* 右上角按钮 */}
      <button
        className="top-right-button"
        onClick={handleRightButtonClick}
      >
        <img src="more.svg" alt="Right Button" />
      </button>
      <Swiper
        loop={false}
        slidesPerView={5}
        initialSlide={0}
        loopAdditionalSlides={2}
        spaceBetween={80}
        speed={800} // 控制滚动速度（平滑滚动）
        mousewheel={true} // 启用鼠标滚轮控制
        freeMode={false} // 启用自由模式
        centeredSlides={true}
        pagination={true} 
        modules={[Pagination]}
        // onSliderFirstMove={handleSlideChangeTransitionEnd}
        
      >
        {/* 使用 map 方法生成每个滑块 */}
        {slidesData.map((name, index) => (
          <SwiperSlide
            key={index} // 使用唯一的 key 以帮助 React 管理每个元素
            className="swiper-slide"
            style={{
              backgroundColor: getRandomColor(),
              borderWidth: '10px',
              borderStyle: 'solid',
              borderColor: 'black', // 黑色边框
              opacity: 0.8,
              visibility: (index <2) ? 'hidden' : 'visible',
            }}
          >
            <div className="text-box">{name}</div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default SwiperComponent;