import './Searcher.css';
import PersonIcon from '@mui/icons-material/Person';
import CollectionsBookmarkIcon from '@mui/icons-material/CollectionsBookmark';
import ToggleButton from "@mui/material/ToggleButton";
import ToggleButtonGroup from "@mui/material/ToggleButtonGroup";
import { useEffect, useState } from 'react';

export const VerticalToggleButtons = () => {
  const [buttonActive, setButtonActive] = useState(false);
  const [userButtonClicked, setUserButtonClicked] = useState(false);
  const [booksButtonClicked, setBooksButtonClicked] = useState(false);


  useEffect(() => {
    // Cambia el estado de buttonActive a true cuando se carga la página
    setButtonActive(true);
  }, []);

  // Maneja la clase del botón de libros de toogleButton a toggleButton-active
  const handleUserButtonClick = () => {
    setUserButtonClicked(true);
  };

  // Maneja la clase del botón de socios de toogleButton a toggleButton-active
  const handleBooksButtonClick = () => {
    setBooksButtonClicked(true);
  };

  return (
    <div>
      <ToggleButtonGroup
        value="books"
        exclusive
      >
        <ToggleButton
          value="book"
          aria-label="book"
            //Se verifican dos condiciones: que buttonActive sea true (lo que ocurre al cargar la página)
            //Y que el botón de socios no haya sido clicado
            //Si ambas condiciones son correctas se aplica la clase toogleButton-active
          className={buttonActive && !userButtonClicked ? 'toogleButton-active' : 'toogleButton'}
            //Al hacer clic también se cambia la clase a toogleButton-active
          onClick={handleBooksButtonClick}
        >
          <CollectionsBookmarkIcon className='toogleIcon' />
        </ToggleButton>
        <ToggleButton
          value="users"
          aria-label="users"
            //Se verifican dos condiciones: que el botón de usuarios se haya clicado
            // que el botón de libros no haya sido clicado
            //si ambas son correctas se cambia la clase a toggleButton-active
          className={userButtonClicked && !booksButtonClicked? 'toogleButton-active' : 'toogleButton'}
           //Al hacer clic se cambia la clase a toogleButton-active
          onClick={handleUserButtonClick}>
          <PersonIcon className='toogleIcon' />
        </ToggleButton>
      </ToggleButtonGroup>
    </div>
  );
};

