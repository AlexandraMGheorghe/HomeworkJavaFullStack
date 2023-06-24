export const ADD_NOTE = "ADD_NOTE";
export const REMOVE_NOTE = "REMOVE_NOTE";
export const EDIT_NOTE = "EDIT_NOTE";
export const SAVE_NOTE = "SAVE_NOTE";

export const addNote = (title, description) => {
    return {
        type: ADD_NOTE,
        payload: {
            title: title,
            description: description,
        },
    };
};

export const removeNote = (noteId) => {
    return {
        type: REMOVE_NOTE,
        payload: {
            noteId: noteId,
        },
    };
};

export const editNote = (noteId, newDescription) => {
    return {
        type: EDIT_NOTE,
        payload: {
            noteId: noteId,
            newDescription: newDescription,
        },
    };
};



export const saveNote = (noteId, updatedDescription) => {
    return {
        type: SAVE_NOTE,
        payload: {
            noteId: noteId,
            updatedDescription: updatedDescription,
        },
    };
};