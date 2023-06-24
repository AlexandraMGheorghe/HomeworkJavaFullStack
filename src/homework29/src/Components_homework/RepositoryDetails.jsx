import {useParams} from "react-router-dom";
import Repos from "./Repos";
import BasicSelect, {MyComp, SelectBar} from "./SelectBar";

const ReposDetails = () => {
    const params = useParams();

    return (
        <div>
            <h1><SelectBar/></h1>
            {/*<MyComp/>*/}
            {/*<h1><BasicSelect/>></h1>*/}
            {Repos.map(e => {
                    return (
                        <div>{e.id}</div>
                    )
                }
            )}
            searchParams.toString() !== '' &&
            (searchParams.get(key) === e.id) &&
            Hello
        </div>

    )

}
export default ReposDetails;






