import Bio from "./Bio"
import React from "react";

class Badge extends React.Component {
    render() {
        return (
            <div
                style={{
                    border: "1px solid black",
                    width: "320px",
                    borderRadius: "16px",
                    padding: "8px",
                    display: "flex",
                    height: "180px",
                }}
            >
                <div style={{width: "75%"}}>
                    <h4>{this.props.firstName}</h4>
                    <h5>{this.props.lastName}</h5>
                </div>
                <Bio
                    birthday={this.props.birthday}
                    description={this.props.description}
                    hobbies={this.props.hobbies}
                />
                <img src={this.props.avatarImage} height="64px" alt="Badge"/>
            </div>

        );
    };
}

export default Badge;

