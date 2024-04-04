// 1. Producer
const promise = new Promise((resolve, reject) => {
  // Producer는 네트워크 작업, 파일 작업 등으로 시간이 소요됨
  console.log("Doing something..");
  setTimeout(() => {
    resolve('작업 결과물');
    reject(new Error("에러 발생"));
  }, 2000);
});

// promise 작업 이후에 해야할 것 **작업 순서 보장
// 2. Consumer 
promise
  .then(value =>{
    console.log(value);
  })

  .catch(error => {
    console.log(error);
  });

