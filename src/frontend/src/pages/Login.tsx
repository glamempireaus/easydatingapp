import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate, Link } from "react-router-dom";
import './Login.css';


import LoginForm from './../components/LoginForm';
import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

import AppConstants from '../contexts/Data';

const Login = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (cookies.get('isLoggedIn') == "true") {
        return <Navigate to={AppConstants.HOME_URL} />;
    }

    return (
        <div className="Login">
            <div className="maincontent container">
                <div>
                    <h1>Login</h1>
                </div>
                <p>Don't have an account? <Link to={AppConstants.REGISTER_URL}>Register now</Link>.</p>

                <LoginForm />
            </div>
            <Footer />
        </div >
    )
}

export default Login;