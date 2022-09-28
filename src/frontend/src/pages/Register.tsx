import { useRef, useState } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Register.css';

import RegisterForm from './../components/RegisterForm';

import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

import AppConstants from '../contexts/Data';

const Register = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (cookies.get('isLoggedIn') == "true") {
        return <Navigate to="/" />;
    }

    return (
        <div className="Register">
            <div className="maincontent container">
                <div>
                    <h1>Register</h1>
                </div>
                <RegisterForm />
            </div>
            <Footer />
        </div>
    )
}

export default Register;