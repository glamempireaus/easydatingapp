import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Home.css';
import AppConstants from '../contexts/Data';

import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

const Home = () => {
    return (
        <div className="Home">
            <MainMenu />
            <div className="maincontent container">
            </div>
            <Footer />
        </div >
    )
}

export default Home;