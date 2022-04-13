
import com.github.music.of.the.ainur.almaren.builder.Core.Implicit
import com.github.music.of.the.ainur.almaren.Almaren
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SaveMode

val almaren = Almaren("Demo")

val sourceDf=almaren.builder.sourceJdbc("jdbc:postgresql://hostname/databasename","org.postgresql.Driver","select * from schema.tablename",Some(username),Some(password)).batch

almaren.builder
.sourceDataFrame(sourceDf).targetJdbc("jdbc:postgresql://hostname/databasename","org.postgresql.Driver", "schema.tablename", SaveMode.Overwrite, Some(username),Some(password),Map("batchsize"->"5000")).batch
