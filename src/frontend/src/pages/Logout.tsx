import { useRef, useState, useEffect, useContext } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Logout.css';

import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

import AppConstants from '../contexts/Data';
import AppContext, { AppProvider } from '../contexts/AppContext';

const Logout = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();
    const appContext = useContext(AppContext);

    useEffect(() => {
        cookies.remove("sessionToken", {
            path: "/"
        });
        cookies.set("isLoggedIn", false, {
            path: "/"
        });

        appContext.setIsLoggedIn(false);
        appContext.setUserToken("");

        navigate(AppConstants.LOGIN_URL);
    });

    if (cookies.get('isLoggedIn') == "false") {
        return <Navigate to={AppConstants.LOGIN_URL} />;
    }

    return (
        <div className="Logout">
            <h1>Logout</h1>
            <Footer />
        </div>
    )
}

export default Logout;