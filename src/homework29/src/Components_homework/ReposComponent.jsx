import Repos from "./Repos";
import {useEffect, useState} from "react";
import {getRepos} from "./HomeComponent_h";
import {Table} from "@mui/material";

const ReposComponent = () => {
    const [reposInfo, setReposInfo] = useState(undefined);
    const columns = [
        {field: "name", headerName: "Nume repo"},
        {field: "owner.login", headerName: "Owner"},
        {field: "url", headerName: "Link", width: 400},
        {field: "description", headerName: "Descriere"},
        {field: "default_branch", headerName: "Default branch"},
    ];

    useEffect(() => {
        getRepos("AlexandraMGheorghe").then((response) => {
            setReposInfo(response.data);
            console.log(reposInfo)
        })
            .catch(() => {
                console.error("Something went wrong")
            })
    }, []);


    return (
        // <table borderColor = "black">
        //     <thead>
        //     <tr>
        //         <thx>Nume repo</thx>
        //         <th>Owner</th>
        //         <th>Link</th>
        //         <th>Descriere</th>
        //         <th>Default branch</th>
        //     </tr>
        //     </thead>
        //     <tbody>
        //     {Repos.map(e => {
        //         return (
        //         <tr bgcolor= {"pink"}>
        //             <td align={"center"}>{e.name}</td>
        //             <td align={"center"}>{e.owner.login}</td>
        //             <td align={"center"}>{e.url}</td>
        //             <td align={"center"}>{e.description}</td>
        //             <td align={"center"}>{e.default_branch}</td>
        //         </tr>
        //         )
        //     })
        //     }
        //     </tbody>
        // </table>
        <div>{reposInfo === undefined && <div>No repos</div>}
            {reposInfo && (
                <table bordercolor="black" align={"center"}>
                    <thead>
                    <tr>
                        {columns.map(e => (
                            <th>{e.headerName}</th>
                        ))}
                    </tr>
                    </thead>
                    {reposInfo.map((repo) => {
                            return (
                                <tbody>
                                <tr bgcolor={"pink"}>
                                    <td align={"center"}>{repo.name}</td>
                                    <td align={"center"}>{repo.owner.login}</td>
                                    <td align={"center"}>{repo.url}</td>
                                    <td align={"center"}>{repo.description}</td>
                                    <td align={"center"}>{repo.default_branch}</td>
                                </tr>
                                </tbody>
                            )
                        }
                    )}

                </table>
            )}
        </div>

    )
}
export default ReposComponent;