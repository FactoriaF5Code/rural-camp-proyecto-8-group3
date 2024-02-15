import './Searcher.css';
import { VerticalToggleButtons } from './VerticalToogleButtons';

export const Searcher = () => {
  return (
    <section className="searchContainer">
      <div className='searchContainer__Field'>
      <VerticalToggleButtons />
        <input
          type="search"
          className="searchContainer__Field-Input"
          placeholder="Búsqueda de libro por título, autor o ISBN"/>
        <button className="searchContainer__Field-Button">
          <img src="/src/assets/searchIcon.svg" alt="búsqueda icono" />
        </button>        
      </div>
    </section>
  )
}