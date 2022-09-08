import React from 'react';
import ReactDOM from 'react-dom/client';
import 'index.css';
import App from 'pages/App';
import Login from 'pages/Login';
import Register from 'pages/Register';
import reportWebVitals from 'reportWebVitals';
import { Cookies } from 'react-cookie';

import { BrowserRouter as Router, Routes, Route }
    from 'react-router-dom';

const isLoggedIn: boolean = false;

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);

const init = () => {
    console.log("Easy Dating Webapp initialising...")

    const cookies = new Cookies();

    // get session token

    const sessionId = cookies.get('sessionId');

    if (sessionId != null) {

    }

}

init();

root.render(
    <React.StrictMode>
        <Router>
            <Routes>
                <Route path='/' element={<App />} />
                <Route path='/login' element={<Login />} />
                <Route path='/register' element={<Register />} />
            </Routes>
        </Router>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
