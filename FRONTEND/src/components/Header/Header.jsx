import "./Header.css";
import logo from "../../assets/greenfield-logo.png";
import { NewMemberButton } from "../NewMemberButton/NewMemberButton";

export const Header = () => {
  return (
    <>
      <header>
        <div>
          <img src={logo} alt="Greenfield Library logo" />
          <h1>Software de gestión de bibliotecas</h1>
        </div>
        <NewMemberButton />
      </header>
    </>
  );
};
