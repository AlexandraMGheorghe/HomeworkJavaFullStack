import React from "react";
import {Link} from "react-router-dom";

export const NavigationBar = (props) => {
    const linkStyle = {
        border: "1px solid #aaaaaa",
        padding: "4px",
        borderRadius: "4px",
        marginLeft: "4px",
        marginRight: "4px",
    };
    return (
        <div style={{padding: "8px"}}>
            <Link style={linkStyle} to="/home">
                Home
            </Link>
            <Link style={linkStyle} to="/repos">
                Repos
            </Link>
            <Link style={linkStyle} to="/repos/:repositoryId">
                Repo details
            </Link>
            <Link style={linkStyle} to="/posts">
                Posts
            </Link>
        </div>
    );
};
export default NavigationBar;