import React from "react";
import {useSearchParams} from "react-router-dom";

const AboutComponent = (props) => {
    const message = props.message;

    const [searchParams, setSearchParams] = useSearchParams();

    console.log(searchParams.toString())

    return (
        <div>
            <h1>{message}</h1>
            {
                searchParams.toString() !== '' &&
                <div>
                    You searched for:
                    {
                        Array.from(searchParams.keys()).map(key => <div>
                            {`${key} --> ${searchParams.get(key)}`}
                        </div>)
                    }
                </div>
            }
            <h3>Contact: mailme@devmind.ro</h3>
        </div>
    );
};

export default AboutComponent;