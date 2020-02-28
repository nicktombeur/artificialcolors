import React from "react";
import {render, unmountComponentAtNode} from "react-dom";
import {act} from "react-dom/test-utils";
import {fireEvent} from '@testing-library/react';

import Dialog from "./Dialog";

let container = null;
beforeEach(() => {
    // setup a DOM element as a render target
    container = document.createElement("div");
    document.body.appendChild(container);
});

afterEach(() => {
    // cleanup on exiting
    unmountComponentAtNode(container);
    container.remove();
    container = null;
});

it("should render or not when visible is set", () => {
    act(() => {
        render(<Dialog visible={true}/>, container);
    });
    expect(container.querySelector(".dialog-footer")).not.toBeNull();

    act(() => {
        render(<Dialog visible={false}/>, container);
    });
    expect(container.querySelector(".dialog-foot")).toBeNull();
});

it("should style based on level", () => {
    act(() => {
        render(<Dialog visible={true} level="error"/>, container);
    });
    expect(container.querySelector("#error-dialog")).not.toBeNull();
});

it("should show message", () => {
    act(() => {
        render(<Dialog visible={true} level="error" message="Something went wrong"/>, container);
    });
    expect(container.querySelector("p").textContent).toBe("Something went wrong");
});

it("should close when button is clicked", () => {
    let visible = true;
    const onClose = () => { visible = false};
    act(() => {
        render(<Dialog visible={visible} level="error" message="Error occurred" onClose={onClose}/>, container);
    });

    const button = document.querySelector("[data-testid=toggle]");
    expect(button.innerHTML).toBe("×");

    act(() => {
        fireEvent.click(button);
    });

    expect(container.querySelector(".dialog-foot")).toBeNull();
});
