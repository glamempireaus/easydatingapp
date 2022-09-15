import React from 'react';
import ReactDOM from 'react-dom/client';
import 'index.css';
import App from 'pages/App';
import Login from 'pages/Login';
import Register from 'pages/Register';
import reportWebVitals from 'reportWebVitals';
import { Cookies } from 'react-cookie';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);

var isLoggedIn;
var sessionToken;

const cookies = new Cookies();

const init = () => {
    console.log("Easy Dating initialising...")

    // get logged in status
    if (cookies.get('isLoggedIn') != "true") {
        cookies.set('isLoggedIn', "false", { path: '/' });
    }
}

init();

root.render(
    <React.StrictMode>
        <Router>
            <Routes>
                <Route path="/"
                    element={
                        isLoggedIn ? (
                            <Navigate replace to="/login" />
                        ) : (
                            <App />
                        )
                    }
                />
                <Route path='/login' element={<Login />} />
                <Route path='/register' element={<Register />} />
                <Route
                    path="*"
                    element={<Navigate to="/" replace />}
                />
            </Routes>
        </Router>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
