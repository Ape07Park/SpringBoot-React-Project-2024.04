function delay(ms) {
  return new Promise(resolver => setTimeout(resolver, ms));

  // setTimeout(() => {}, ms);
}

function getApple() {
  delay(3000);  // 시간이 소요되는 작업
  return "맛있는 사과";
}

// 프로미스랑 똑같이 해야 함 
async function getBanana(){
  await delay(3000);
  return "제때 찾아오는 바나나";
}
// console.log(getApple());
getBanana()
  .then(data => {console.log(data);});

