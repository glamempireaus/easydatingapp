import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Messages.css';

import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

import AppConstants from '../contexts/Data';

const Messages = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (cookies.get('isLoggedIn') == "false") {
        return <Navigate to={AppConstants.LOGIN_URL} />;
    }

    return (
        <div className="Messages">
            <MainMenu />
            <div className="maincontent container">
                <div>
                    <h1>Messages</h1>
                </div>
            </div>
            <Footer />
        </div>
    )
}

export default Messages;