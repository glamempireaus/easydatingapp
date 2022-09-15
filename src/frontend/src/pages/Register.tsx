import { useRef, useState } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";


import RegisterForm from './../components/RegisterForm';

const Register = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (cookies.get('isLoggedIn') == "true") {
        return <Navigate to="/" />;
    }

    return (
        <div className="Main">
            <h1>Register</h1>
            <RegisterForm />
        </div>
    )
}

export default Register;