'use client'

import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import { NextPage } from "next";
import { findAllArticles, saveArticle } from "@/app/components/article/service/article.service";
import { useSelector, useDispatch } from 'react-redux'
import { MyTypography } from '@/app/components/common/style/cell';
import { AttachFile, FmdGood, ThumbUpAlt } from '@mui/icons-material';
import FmdGoodIcon from '@mui/icons-material/FmdGood';
import AttachFileIcon from '@mui/icons-material/AttachFile';
import ThumbUpAltIcon from '@mui/icons-material/ThumbUpAlt';
import { IArticle } from '@/app/components/article/model/article.model';
import { getauth } from '@/app/components/article/service/article.slice';
import { useRouter } from 'next/navigation';



export default function WriterArticlesPage ({params}: any)  {
  const [article,setArticle] = useState({} as IArticle)
  const autharticle  = useSelector(getauth) 
  const dispatch = useDispatch()
  const router = useRouter();

  const handleonTitle = (e:any)=>{
    setArticle({...article,
      title: e.target.value})
    
}
const handleonContent = (e:any)=>{
  setArticle({...article,
    content: e.target.value})
}
const handleonId = (e:any)=>{
  setArticle({...article,
    boardId: e.target.value})
}

    const handelCancel = ()=>{}
    const handleSubmit = ()=>{
      
      dispatch(saveArticle(article))}
      useEffect(()=>{
        if(autharticle.message ==='SUCCESS'){
          router.push(`/pages/articles/search/${article.boardId}`)
        }else{
          console.log('save FAIL')
          console.log(autharticle.message)
        }
      },[autharticle])


    return (<>
    
<form className="max-w-sm mx-auto">
  <label htmlFor="BOARDTYPE" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Select your BOARDTYPE</label>
  <select onChange={handleonId} id="BOARDID" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">

    <option> 1 </option>
    <option> 2 </option>
    
  </select>
</form>









       <div className="editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl">
      {MyTypography('Article 작성', "1.5rem")}
      <input className="title bg-gray-100 border border-gray-300 p-2 mb-4 outline-none" placeholder="Title" type="text" name="title" onChange={handleonTitle} />
      <input className='id' name='id' onChange={handleonId}/>
      <textarea className="description bg-gray-100 sec p-3 h-60 border border-gray-300 outline-none" placeholder="Describe everything about this post here" name="content" onChange={handleonContent}></textarea>
      {/* <!-- icons --> */}
      <div className="icons flex text-gray-500 m-2">
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <ThumbUpAltIcon component={ThumbUpAlt}></ThumbUpAltIcon>
        </svg>
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <FmdGoodIcon component={FmdGood}></FmdGoodIcon>
        </svg>
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <AttachFileIcon component={AttachFile}></AttachFileIcon>
        </svg>
        <div className="count ml-auto text-gray-400 text-xs font-semibold">0/300</div>
      </div>
      {/* <!-- buttons --> */}
      <div className="buttons flex">
        <div className="btn  overflow-hidden relative w-30 bg-white text-blue-500 p-3 px-4 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          onClick={handelCancel}>Cancel</div>
        <div className="btn  overflow-hidden relative w-30 bg-blue-500 text-white p-3 px-8 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          onClick={handleSubmit}> Post </div>
      </div>
    </div>
    </>)
}

