import { useRef, useState } from "react";
import './Header.css';

import SubMenu from './SubMenu';

const Header = () => {
    return (
        <div className="Header">
            EasyDatingApp
            <SubMenu />
        </div>
    )
}

export default Header;