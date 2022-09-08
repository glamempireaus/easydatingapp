import { useRef, useState } from "react";

import LoginForm from './../components/LoginForm';

const Login = () => {
    return (
        <div className="Main">
            <h1>Login</h1>
            <LoginForm />
        </div>
    )
}

export default Login;