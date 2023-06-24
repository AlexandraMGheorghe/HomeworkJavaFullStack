import { ADD_NOTE, REMOVE_NOTE, EDIT_NOTE, SAVE_NOTE } from "./action";

const initialState = {
    notes: [],
};

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_NOTE:
            return {
                ...state,
                notes: [
                    ...state.notes,
                    {
                        title: action.payload.title,
                        description: action.payload.description,
                    },
                ],
            };
        case REMOVE_NOTE:
            return {
                ...state,
                notes: state.notes.filter((note) => note.title !== action.payload.title),
            };
        case EDIT_NOTE:
            return {
                ...state,
                notes: state.notes.map((note) => {
                    if (note.title === action.payload.title) {
                        return {
                            ...note,
                            description: action.payload.description,
                        };
                    }
                    return note;
                }),
            };
        case SAVE_NOTE:

            return{
            ...state,
            notes: [
                ...state.notes,
                {
                    title: action.payload.title,
                    description: action.payload.description,
                },
            ],
        };
        default:
            return state;
    }
};

export default rootReducer;
