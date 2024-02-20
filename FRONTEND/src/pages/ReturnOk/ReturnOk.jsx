import { SecondaryHeader } from "../../components/Header/SecondaryHeader"
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import './ReturnOk.css'

export const ReturnOk = () => {
  return (
    <>
      <SecondaryHeader />
      <section className="returnOk">
        <CheckCircleIcon className='returnOk__checkIcon'/>
        <h2 className="returnOk__title">Devolución realizada correctamente del libro:</h2>
        <ul className="returnOk__book">
          <li className="returnOk__book-text">#1</li>
          <li className="returnOk__book-text">0124-5478-5789-5</li>
          <li className="returnOk__book-text">Los últimos balleneros</li>
          <li className="returnOk__book-text">Doug Bock Clark</li>
        </ul>
      </section>
    </>
  )
}
