import React, { createContext, useContext } from 'react';
import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useEffect } from 'react';
import { Cookies } from "react-cookie";
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import AppConstants from '../contexts/Data';
import { AppContext, AppProvider } from '../contexts/AppContext';

import './App.css';

import Home from '../pages/Home';
import Login from '../pages/Login';
import Logout from '../pages/Logout';
import Register from '../pages/Register';
import Messages from '../pages/Messages';
import Profile from '../pages/Profile';

const App = () => {

    const cookies = new Cookies();
    const currentPath = window.location.pathname;

    const appContext = useContext(AppContext);
    console.log(appContext.isLoggedIn);

    console.log("Easy Dating App started.")


    // get logged in status, then generate login status

    if (cookies.get('isLoggedIn') != "true") {
        cookies.set('isLoggedIn', "false", { path: '/' });

        console.log("You aren't logged in.");
        appContext.setIsLoggedIn(false);
    }
    else {
        console.log("You are logged in.");
        appContext.setIsLoggedIn(true);
    }

    console.log(Boolean(cookies.get('isLoggedIn')));
    console.log(appContext.isLoggedIn);

    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path={AppConstants.HOME_URL} element={<Home/>} />
                    <Route path={AppConstants.LOGIN_URL} element={<Login/>} />
                    <Route path={AppConstants.LOGOUT_URL} element={<Logout/>} />
                    <Route path={AppConstants.MESSAGES_URL} element={<Messages/>} />
                    <Route path={AppConstants.PROFILE_URL} element={<Profile/>} />
                    <Route path={AppConstants.REGISTER_URL} element={<Register/>} />
                    <Route path="*" element={<Navigate to={appContext.isLoggedIn ? AppConstants.HOME_URL: AppConstants.LOGIN_URL} replace />} />
                </Routes>
            </Router>
        </div>
    )
}

export default App;
export { AppConstants }



