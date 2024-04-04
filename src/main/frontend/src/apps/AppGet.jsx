import React, { useEffect, useState } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

function App() {
  const [data, setData] = useState('');
  const [user, setUser] = useState({});

  useEffect(() => {
    axios.get('/rp/react/data')
      .then(res => { // res 객체. 데이터는 res.data로 들어옴
        console.log(res);
        setData(res.data);
      })
      .catch(err => {console.log(err);});
  }, []);

  useEffect(() => {
    axios.get('/rp/react/json')
    // 사용자 정보 객체 전체를 setUser에 저장
      .then(res => setUser(res.data))  // axios로 받은 Json 데이터는 자동으로 Json이 풀어해쳐짐, 
      .catch(err => console.log(err));
  }, []);
  
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h3>
          받아온 값: {data ? data : '받아오지 못했어요.'}
        </h3>
        <h3>
          사용자 정보: uid={user.uid}, uname={user.uname}
        </h3>
      </header>
    </div>
  );
}

export default App;