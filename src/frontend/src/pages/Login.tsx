import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";


import LoginForm from './../components/LoginForm';

const Login = () => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (cookies.get('isLoggedIn') == "true") {
        return <Navigate to="/" />;
    }

    return (
        <div className="Main">
            <h1>Login</h1>
            <LoginForm />
        </div>
    )
}

export default Login;