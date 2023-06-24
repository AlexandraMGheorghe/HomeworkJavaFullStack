import {useEffect, useState} from "react";
import Info from "./Info";
import {useNavigate, useParams} from "react-router-dom";
import React from "react";
import axios from "axios";
import Box from "@mui/material/Box";
import {DataGrid} from "@mui/x-data-grid";


const HomeComponent_h = () => {
    const navigate = useNavigate();
    const [info, setInfo] = useState(undefined);
    const columns = [
        {field: "id", headerName: "ID"},
        {field: "public_repos", headerName: "userId"},
    ];

    useEffect(() => {
        getInfo("AlexandraMGheorghe").then((response) => {
            setInfo(response.data)
            console.log(info)
        });
    }, []);

    return (
        <div>
            <button onClick={() => navigate('/repos')}>Go to repos section</button>

            <div>{info === undefined &&
                <div>Nu exista date</div>}
            </div>

            <div>{info && (
                <div>
                    <p>{`User name: ${info.login}`}</p>
                    <p>{`Public repos: ${info.public_repos}`}</p>
                    <p>{`Followers: ${info.followers}`}</p>
                    <p> {`Following: ${info.following}`}</p>
                    <p><img src={info.avatar_url}/></p>
                </div>
            )}
            </div>
        </div>
    )
}
export default HomeComponent_h;

const INFO_URL = "https://api.github.com/users/";

export const getInfo = (userName) => axios.get(`${INFO_URL}${userName}`)

export const getRepos = (userName) => axios.get(`${INFO_URL}${userName}/repos`)