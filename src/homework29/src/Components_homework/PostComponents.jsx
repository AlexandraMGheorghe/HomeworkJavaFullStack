import axios from "axios";
import {Fragment, useEffect, useState} from "react";
import {getInfo} from "./HomeComponent_h";
import {DataGrid} from "@mui/x-data-grid";
import Box from "@mui/material/Box";
import UserModal from "./UserModal";
import {Modal, Table} from "@mui/material";
import React from "react";

const POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
const COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments?postId=";
const POST_COMMENT = "https://jsonplaceholder.typicode.com/posts";

export const getPosts = () => axios.get(`${POSTS_URL}`)
export const getComments = (postId) => axios.get(`${COMMENTS_URL}${postId}`)


export const PostsComponents = () => {
    const [posts, setPosts] = useState(undefined);
    const [modalData, setModalData] = useState(undefined);
    const [title, setTitle] = useState(undefined);
    const [body, setBody] = useState(undefined);
    const [userId, setUserId] = useState(undefined);

    const columns = [
        {field: "userId", headerName: "user Id"},
        {field: "id", headerName: "ID"},
        {field: "title", headerName: "Title", width: 400},
        {field: "body", headerName: "Body"},
    ];

    const boxStyle = {
        width: 480,
        bgcolor: 'background.paper',
        border: '2px solid #000',
        boxShadow: 24,
        p: 4,
    }

    useEffect(() => {
        getPosts().then((response) => {
            setPosts(response.data)
        });
    }, []);

    const onCellClick = (cellInfo) => {
        const postId = cellInfo.row.id;
        getComments(postId)
            .then((userData) => {
                setModalData(userData.data);
            })
            .catch(() => {
                console.error("Something went wrong");
            });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        addPosts(title, body, userId);
    };

    const addPosts = (title, body, userId) => {
        axios
            .post('POST_COMMENT', {
                title: title,
                body: body,
                userId: userId
            })
            .then((response) => {
                setPosts([response.data, ...posts]);
                console.log(response);
            });
        setTitle('');
        setBody('');
        setUserId('');
        // return posts;
    };

    return (
        <Fragment>
            <form>
                <label>
                    Title:
                    <input type="text" name="name"/>
                </label>
                <label>
                    User ID:
                    <input type="text" name="name"/>
                </label>
                <label>
                    Body:
                    <input type="text" name="name"/>
                </label>
                <input type="submit" value="Submit"
                       onClick={handleSubmit}/>
            </form>

            <Box width="100%" height={1000} display="flex" justifyContent="center">
                {posts === undefined && <div>There is no post</div>}
                {posts && (
                    <Box width="80%" height="100%">
                        <DataGrid onCellClick={onCellClick} rows={posts} columns={columns}/>
                    </Box>
                )}
                {modalData &&
                    // <Modal
                    // modalData={modalData}
                    //     open = {true}
                    //     onClose={() => setModalData(undefined)}>
                    //     <Box style={boxStyle}>
                    //       hello
                    //     </Box>
                    // </Modal>
                    <UserModal modalData={modalData} onClose={() => setModalData(undefined)}/>}
                }
            </Box>

        </Fragment>

    );


}