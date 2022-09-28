import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Logout.css';
import AppConstants from '../contexts/Data';

import Footer from '../components/Footer';

const Error = () => {

    return (
        <div className="Error">
            <h1>Error 404</h1>
            <Footer />
        </div>
    )
}

export default Error;