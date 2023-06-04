import React from "react";

class Bio extends React.Component {
    render() {
        const {birthday, description, hobbies} = this.props;
        const isProgrammer = hobbies.includes("Java") || hobbies.includes("React");


        return (
            <div>
                <p>Data nașterii: {birthday}</p>
                <p>Descriere: {description}</p>
                <p>Programmer: {isProgrammer ? "TRUE" : "FALSE"}</p>
            </div>
        );
    }
};

export default Bio;
