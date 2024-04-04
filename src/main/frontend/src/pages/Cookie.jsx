import React, { useState } from 'react';
import axios from 'axios';
import { withCookies, ReactCookieProps } from 'react-cookie';

export default function Cookie() {
  const [form, setForm] = useState({uid:'', uname:''});
  const handleChange = (event) => {
    const { name, value } = event.target;
    setForm({ ...form, [name]: value });
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    const params = new URLSearchParams();
    params.append('uid', form.uid);
    params.append('uname', form.uname);
    axios
      .post('/rp/react/cookie', params)
      .then(res => {console.log(res);});
  }
  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <label htmlFor='uid'>아이디:</label>
        <input type='text' id='uid' name='uid' value={form.uid} onChange={handleChange} /><br />
        <label htmlFor='name'>이름:</label>
        <input type='text' id='uname' name='uname' value={form.uname} onChange={handleChange} /><br />
        <button>확인</button>
      </form>
    </div>
  );
}