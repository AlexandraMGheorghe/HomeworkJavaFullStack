import React from "react";
import { useDispatch } from "react-redux";
import { removeNote } from "../redux/action";

const RemoveButton = ({ title }) => {
    const dispatch = useDispatch();

    const handleDelete = () => {
        dispatch(removeNote(title));
    };

    return <button onClick={handleDelete}>Remove</button>;
};

export default RemoveButton;