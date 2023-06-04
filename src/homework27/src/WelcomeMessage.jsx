import React, { useState, useEffect } from "react";

const WelcomeMessage = () => {
    const [message, setMessage] = useState("Please wait...");

    useEffect(() => {
        setTimeout(() => {
            setMessage("Welcome to Devmind!");
        }, 3000);
    }, []);
    return <h1>{message}</h1>;
};

export default WelcomeMessage;
