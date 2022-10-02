import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Home.css';
import AppConstants from '../contexts/Data';

import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

const Home = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (cookies.get('isLoggedIn') == "false") {
        return <Navigate to={AppConstants.LOGIN_URL} />;
    }

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