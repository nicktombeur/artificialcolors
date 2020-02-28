import React, {Suspense} from "react";
import ReactDOM from "react-dom";
import App from "./scenes/app/App";
import "./index.css";
import "./i18n";

ReactDOM.render(<Suspense fallback="Loading"><App/></Suspense>, document.getElementById("root"));
