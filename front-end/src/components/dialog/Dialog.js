import React, {Component} from "react";
import "./Dialog.scss";
import "dialog-polyfill/dist/dialog-polyfill.css";
import dialogPolyfill from "dialog-polyfill";

export default class Dialog extends Component {

    componentDidMount() {
        if (!this.isDialogSupported() && this.props.visible) {
            let dialogSelected = document.querySelector('dialog');
            dialogPolyfill.registerDialog(dialogSelected);
        }
    }

    isDialogSupported(){
        let dialog = document.createElement("dialog");
        return Object.prototype.toString.call(dialog) !== '[object HTMLUnknownElement]';
    }

    render() {
        if (this.props.visible) {
            return (
                <footer className="dialog-footer">
                    <dialog open id={this.props.level + "-dialog"}>
                        <form method="dialog">
                            <menu>
                                <button value="default"
                                        onClick={this.props.onClose}
                                        data-testid="toggle">
                                    &times;
                                </button>
                            </menu>
                            <p>{this.props.message}</p>
                        </form>
                    </dialog>
                </footer>
            );
        } else {
            return null;
        }
    }

}
