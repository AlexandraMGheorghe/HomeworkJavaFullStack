import * as React from "react";
import {Navigate} from "react-router-dom";

class Contact extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            shouldNavigate: false
        }
    }

    render() {
        return (
            <div>
                {this.state.shouldNavigate && (
                    <Navigate to="/about" replace={true}/>
                )}
                <button onClick={() => this.setState({
                    shouldNavigate: true
                })}>
                    Go to About section
                </button>
            </div>
        );
    }

}

export default Contact;