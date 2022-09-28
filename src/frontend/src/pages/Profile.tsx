import { useRef, useState, useEffect } from "react";
import { Cookies } from "react-cookie";
import { useNavigate, Navigate } from "react-router-dom";
import './Profile.css';

import SubMenu from '../components/SubMenu';
import MainMenu from '../components/MainMenu';
import Footer from '../components/Footer';

import AppConstants from '../contexts/Data';

const Profile = () => {

    return (
        <div className="Profile">
            <MainMenu />
            <div className="container maincontent">
                <div className="gridlayout" style={{ marginLeft: "5rem", marginRight: "5rem" }}>
                    <div className="gridelement">
                        <h3>Edit Profile</h3>
                    </div>
                    <div className="gridelement">
                        <h3>HELfsdfdOHL</h3>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    )
}

export default Profile;