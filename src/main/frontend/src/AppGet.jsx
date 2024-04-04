import React, { useEffect, useState } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

function App() { 
  const [user, setUser] = useState({
    
  });
    
  useEffect(() => {
    axios
      .get('/rp/react/list')
      .then(res => setUser(res.data))  // axios로 받은 Json 데이터는 자동으로 Json이 풀어해쳐짐
      
      .catch(err => console.log(err));
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h3>
          스프링부트에서 불러온 정보
        </h3>       
          <h3>
            
          </h3>   
          {user ? user.map((users)=>(
                    <div key={users.uid}>
                        <div>id: {users.uid}</div>
                        <div>uname: {users.uname}</div>
                        <div>email: {users.email}</div>                        
                    </div>
                )) : ''}      
      </header>
    </div>
  );
}

export default App;