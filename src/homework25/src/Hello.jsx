const message = "Hello, Devmind!";
const isLoggedIn = false;
const containerClassname = "containerClass";
const container = (
    <div id="container" className={containerClassname}>
        <img width="200px" src="https://www.devmind.ro/static/imgs/logo.png" />
        {isLoggedIn && <h3>{message}</h3>}
        {!isLoggedIn && <h3>User not found! :(</h3>}
    </div>
);