import "./Header.css";
import logo from "../../assets/greenfield-logo.png";

export const Header = () => {
  return (
    <>
      <header>
        <img src={logo} alt="Greenfield Library logo" />
        <h1>Software de gestión de bibliotecas</h1>
      </header>
    </>
  );
};
