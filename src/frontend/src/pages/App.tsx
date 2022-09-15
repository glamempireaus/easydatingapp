import React, { createContext, useState } from 'react';
import { useCookies } from 'react-cookie';
import { Cookies } from "react-cookie";
import logo from './logo.svg';
import './App.css';

import Footer from '../components/Footer';
import Header from '../components/Header';
import Main from '../components/Main';
import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';

const App = () => {

    const cookies = new Cookies();

    const UserContext = createContext({
        isLoggedIn: false,

        userName: "",
        firstName: "",
        lastName: "",
    });

    return (
        <div className="App">
            <div id="headerContainer" className="HeaderContainer">
                <MainMenu />
                <SubMenu />
            </div>
            <div id="mainContainer" className="MainContainer">
                <Main />
            </div>
            <div id="footerContainer" className="FooterContainer">
                <Footer />
            </div>
        </div>
    )
}

export default App;
