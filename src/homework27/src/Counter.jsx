import React, {useState} from "react";
const Counter = () =>{
    const [count, setCount] = useState(0);

    const increment = () => {
        setCount(count+1);
    };

    const decrement = () => {
        setCount(count-1);
    }

    console.log("Counter component rendered");
    console.log("Counter value:", count);

    return (
        <div>
            <p>Counter: {count}</p>
            <button onClick={decrement}>Decrement</button>
            <button onClick={increment}>Increment</button>
        </div>
    );
};

export default Counter;