package nl.wur.alterra.cgi.ace.harvester;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.portlet.CustomPropertiesNotInitializedException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Scheduled thread to invoke a harvesting run in GeoNetwork, wait for it to complete, retrieve its results and
 * store them as AceItems.
 *
 * @author heikki doeleman
 */
public class HarvesterThread implements RunnableFuture {

    private WxsHarvester wxsHarvester;
    private CSWHarvester cswHarvester;

    public HarvesterThread(WxsHarvester wxsHarvester) {
        this.wxsHarvester = wxsHarvester;
    }
    public HarvesterThread(CSWHarvester cswHarvester) {
        this.cswHarvester = cswHarvester;
    }

    Semaphore ready = new Semaphore(0);

    /**
     * Sets this Future to the result of its computation unless it has been cancelled.
     */
    public void run() {
        //System.out.println("HarvesterThread run start");
        try {
            HarvesterUtil.executeWxsHarvester(this.wxsHarvester);
        }
        catch (SystemException x) {
            System.out.println("ERROR: " + x.getMessage());
            x.printStackTrace();
        }
        catch (PortalException x) {
            System.out.println("ERROR: " + x.getMessage());
            x.printStackTrace();
        }
        catch (CustomPropertiesNotInitializedException x) {
            System.out.println("ERROR: " + x.getMessage());
            x.printStackTrace();
        }
        ready.release();
        //System.out.println("HarvesterThread run end");
    }

    /**
     * Attempts to cancel execution of this task. This attempt will fail if the task has already completed, has already
     * been cancelled, or could not be cancelled for some other reason. If successful, and this task has not started
     * when <tt>cancel</tt> is called, this task should never run. If the task has already started, then the
     * <tt>mayInterruptIfRunning</tt> parameter determines whether the thread executing this task should be interrupted
     * in an attempt to stop the task.
     * <p/>
     * <p>After this method returns, subsequent calls to {@link #isDone} will always return <tt>true</tt>.  Subsequent
     * calls to {@link #isCancelled} will always return <tt>true</tt> if this method returned <tt>true</tt>.
     *
     * @param mayInterruptIfRunning <tt>true</tt> if the thread executing this task should be interrupted; otherwise,
     *                              in-progress tasks are allowed to complete
     * @return <tt>false</tt> if the task could not be cancelled, typically because it has already completed normally;
     *         <tt>true</tt> otherwise
     */
    public boolean cancel(boolean mayInterruptIfRunning) {
        // TODO should we implement something here ?
        return false;
    }

    /**
     * Returns <tt>true</tt> if this task was cancelled before it completed normally.
     *
     * @return <tt>true</tt> if this task was cancelled before it completed
     */
    public boolean isCancelled() {
        return false;
    }

    /**
     * Returns <tt>true</tt> if this task completed.
     * <p/>
     * Completion may be due to normal termination, an exception, or cancellation -- in all of these cases, this method
     * will return <tt>true</tt>.
     *
     * @return <tt>true</tt> if this task completed
     */
    public boolean isDone() {
        return false;
    }

    /**
     * Waits if necessary for the computation to complete, and then retrieves its result.
     *
     * @return the computed result
     * @throws java.util.concurrent.CancellationException
     *                              if the computation was cancelled
     * @throws java.util.concurrent.ExecutionException
     *                              if the computation threw an
     *                              exception
     * @throws InterruptedException if the current thread was interrupted
     *                              while waiting
     */
    public Object get() throws InterruptedException, ExecutionException {
        ready.acquire();
        return null;
    }

    /**
     * Waits if necessary for at most the given time for the computation to complete, and then retrieves its result, if
     * available.
     *
     * @param timeout the maximum time to wait
     * @param unit    the time unit of the timeout argument
     * @return the computed result
     * @throws java.util.concurrent.CancellationException
     *                              if the computation was cancelled
     * @throws java.util.concurrent.ExecutionException
     *                              if the computation threw an
     *                              exception
     * @throws InterruptedException if the current thread was interrupted
     *                              while waiting
     * @throws java.util.concurrent.TimeoutException
     *                              if the wait timed out
     */
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        ready.acquire();
        return null;
    }
}
