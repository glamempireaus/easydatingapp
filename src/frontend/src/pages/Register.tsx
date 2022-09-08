import { useRef, useState } from "react";

import RegisterForm from './../components/RegisterForm';

const Register = () => {
    return (
        <div className="Main">
            <h1>Register</h1>
            <RegisterForm />
        </div>
    )
}

export default Register;