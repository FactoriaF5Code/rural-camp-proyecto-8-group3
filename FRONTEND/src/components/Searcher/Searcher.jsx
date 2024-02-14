// import { BookIcon } from '../../svg/BookIcon'
import './Searcher.css';

export const Searcher = () => {
  return (
    <section className="searchContainer">
      <div className='searchContainer__Field'>
        <div className='searchContainer__Field-icon'> 
          <img src="/src/assets/bookIcon.svg" alt="libro icono" />
        </div>
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
