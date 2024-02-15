import { test } from "vitest";
import { render } from "@testing-library/react";
import { NewMember } from '../components/NewMember/NewMember'

test("El NewMember se renderiza", () => {
    render(<NewMember />);  
});