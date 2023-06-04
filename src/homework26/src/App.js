import React from "react";
import "./App.css";
import Badge from "./Badge.js";
class App extends React.Component {
    render() {

        const badgesProps = [
            {
                firstName: "Johhny",
                lastName: "Depp",
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIMJf32XCdIMPR005aLZbkk5TldBubjW2CfA&usqp=CAU",
                birthday: "02/03/1978",
                description: "actor",
                hobbies: "movies, sport"
            },
            {
                firstName: "Tommy",
                lastName: "Williams",
                img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
                birthday: "04/05/1987",
                description: "sportiv",
                hobbies: "music"
            },
            {
                firstName: "Tom",
                lastName: "Willi",
                img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
                birthday: "02/08/1998",
                description: "programmer",
                hobbies: "cars, bikes, Java"
            }
        ];

        return (
            <div id="container">

                {badgesProps.map((badge) => (
                    <Badge
                        firstName={badge.firstName}
                        lastName={badge.lastName}
                        avatarImage={badge.img}
                        birthday={badge.birthday}
                        description={badge.description}
                        hobbies={badge.hobbies}
                    />
                ))}

            </div>
        );
    }
}

export default App;
